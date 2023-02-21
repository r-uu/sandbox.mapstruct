package department;

import static lombok.AccessLevel.PROTECTED;

import department.MapStructMapper.Default;
import department.MapStructMapper.MapStructContext;
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
@NoArgsConstructor(access = PROTECTED) // generate no args constructor for jpa, mapstruct, ...
@Getter()
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class DepartmentEntity
{
	@NonNull @Setter private String name;

	/**
	 * let this be used by mapstruct (@Default, @ObjectFactory) and make sure to manually call required args constructor
	 * @param department incoming entity to be used for construction of instance
	 * @param context incoming context to properly handling cyclic dependencies
	 */
	@Default // necessary make sure mapstruct does not use no-args-constructor
	public DepartmentEntity(@NonNull DepartmentDTO department, @NonNull MapStructContext context)
	{
		this(department.name());
		log.debug("context {}", context);
	}
}