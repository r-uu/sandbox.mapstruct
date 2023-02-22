package department_employee_bidirectional;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PROTECTED;

import static department_employee_bidirectional.MapStructMapper.MapStructContext;

import department_employee_bidirectional.MapStructMapper.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@NoArgsConstructor(access = PROTECTED) // generate no args constructor for jsonb, jaxb, mapstruct, ...
@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class DepartmentDTO
{
	@NonNull @Setter private String name;

	/** may be null to indicate that employees are not yet loaded */
	@EqualsAndHashCode.Exclude
	private Set<EmployeeDTO> employees;

	/**
	 * let this be used by mapstruct (@Default, @ObjectFactory) and make sure to manually call required args constructor
	 * @param department incoming entity to be used for construction of instance
	 * @param context incoming context to properly handling cyclic dependencies
	 */
	@Default // necessary make sure mapstruct does not use no-args-constructor
	public DepartmentDTO(@NonNull DepartmentEntity department, @NonNull MapStructContext context)
	{
		this(department.name());
		log.debug("context {}", context);

		if (isNull(department.employees()) == false)
		{
			// TODO no, we should use a mapstruct mapper for that
			department.employees().forEach(e -> add(new EmployeeDTO(e, context)));
		}
	}

	/** return unmodifiable */
	public Set<EmployeeDTO> employees()
	{
		if (isNull(employees)) return null;
		return Set.copyOf(employees);
	}

	// TODO do not expose add and remove but set(Department)
	public boolean add(@NonNull EmployeeDTO employee) { return nonNullEmployees().add(employee); }
	public boolean remove(@NonNull EmployeeDTO employee)
	{
		if (isNull(employees)) return false;
		return employees.remove(employee);
	}

	private Set<EmployeeDTO> nonNullEmployees()
	{
		if (isNull(employees)) return new HashSet<>();
		return employees;
	}
}