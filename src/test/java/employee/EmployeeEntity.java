package employee;

import employee.MapStructMapper.Default;
import employee.MapStructMapper.MapStructContext;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import static lombok.AccessLevel.PROTECTED;

@Slf4j
@RequiredArgsConstructor
@NoArgsConstructor(access = PROTECTED) // generate no args constructor for jpa, mapstruct, ...
@Getter()
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class EmployeeEntity
{
	@NonNull @Setter private String name;

	/**
	 * let this be used by mapstruct (@Default, @ObjectFactory) and make sure to manually call required args constructor
	 * @param department incoming DTO to be used for construction of instance
	 * @param context incoming context to properly handling cyclic dependencies
	 */
	@Default // necessary make sure mapstruct does not use no-args-constructor
	public EmployeeEntity(@NonNull EmployeeDTO department, @NonNull MapStructContext context)
	{
		this(department.name());
		log.debug("context {}", context);
	}
}