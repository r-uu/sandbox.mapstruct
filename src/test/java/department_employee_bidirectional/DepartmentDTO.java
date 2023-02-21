package department_employee_bidirectional;

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

//	/** may be null to indicate that manies are not yet loaded */
//	@EqualsAndHashCode.Exclude
//	private Set<EmployeeDTO> employees;

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
		// TODO handle manies

//		if (isNull(department.manies()) == false) { manies = new HashSet<>(manies); }
	}

//	/** return unmodifiable */
//	public Set<Many> employees() { return Set.copyOf(employees); }

//	public boolean add(Employee employee) { return employees.add(employee); }
}