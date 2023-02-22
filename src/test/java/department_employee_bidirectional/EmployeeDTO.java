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
import department_employee_bidirectional.MapStructMapper.Default;
import department_employee_bidirectional.MapStructMapper.MapStructContext;

@Slf4j
// @RequiredArgsConstructor // do not generate required args constructor for @NonNull fields because @NonNull constraint
                            // is not guaranteed
@NoArgsConstructor(access = PROTECTED)
@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class EmployeeDTO
{
	/** mutable, but not nullable */
	@NonNull @Setter private String name;

	/** mutable, but not nullable */
	@NonNull @Setter private DepartmentDTO department;

	/**
	 * constructor with parameters for each non-nullable field
	 * <p>common clients use this constructor
	 */
	public EmployeeDTO(@NonNull String name, @NonNull DepartmentDTO department)
	{
		name(name);
		department(department);
		department.add(this);
	}

	/** let this be used by mapstruct, manually map each immutable (no setter) field */
	@Default
	public EmployeeDTO(@NonNull EmployeeEntity employee, @NonNull MapStructContext context)
	{
		this(employee.name(), MapStructMapper.INSTANCE.map(employee.department(), context));
		log.debug("context {}", context);
	}
}