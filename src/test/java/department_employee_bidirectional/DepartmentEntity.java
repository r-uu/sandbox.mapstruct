package department_employee_bidirectional;

import static lombok.AccessLevel.PROTECTED;

import department_employee_bidirectional.MapStructMapper.Default;
import department_employee_bidirectional.MapStructMapper.MapStructContext;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@NoArgsConstructor(access = PROTECTED) // generate no args constructor for jpa, mapstruct, ...
@Getter()
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class DepartmentEntity
{
	@NonNull @Setter private String name;

//	//may be null
//	@EqualsAndHashCode.Exclude
//	private Set<Many> employees;

	/**
	 * let this be used by mapstruct (@Default, @ObjectFactory) and make sure to manually call required args constructor
	 * @param department incoming DTO to be used for construction of instance
	 * @param context incoming context to properly handling cyclic dependencies
	 */
	@Default // necessary make sure mapstruct does not use no-args-constructor
	public DepartmentEntity(@NonNull DepartmentDTO department, @NonNull MapStructContext context)
	{
		this(department.name());
		log.debug("context {}", context);
		// TODO handle employees
	}

//	/** return unmodifiable */
//	public Set<Many> employees() { return Set.copyOf(employees); }

//	public boolean add(Many many) { return employees.add(many); }
}