package department_employee_bidirectional;

import static lombok.AccessLevel.PROTECTED;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import department_employee_bidirectional.MapStructMapper.MapStructContext;

@Slf4j
//@RequiredArgsConstructor // do not generate required args constructor for @NonNull fields because @NonNull constraint
// is not guaranteed
@NoArgsConstructor(access = PROTECTED)
@Getter()
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class EmployeeEntity
{
	/** mutable, but not nullable */
	@NonNull @Setter private String name;

	/** mutable, but not nullable */
	@NonNull @Setter private DepartmentEntity department;

	/**
	 * constructor with parameters for each non-nullable field
	 * <p>common clients use this constructor
	 */
	public EmployeeEntity(@NonNull String name, @NonNull DepartmentEntity department)
	{
		name(name);
		department(department);
	}

	/** let this be used by mapstruct, manually map each immutable (no setter) field */
	@MapStructMapper.Default
	public EmployeeEntity(@NonNull EmployeeDTO employee, @NonNull MapStructContext context)
	{
		this(employee.name(), new DepartmentEntity(employee.department(), context));
		log.debug("context {}", context);
	}
}