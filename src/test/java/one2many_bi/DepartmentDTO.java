package one2many_bi;

import static lombok.AccessLevel.PROTECTED;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @RequiredArgsConstructor // do not generate required args constructor for @NonNull fields because @NonNull constraint
                            // is not guaranteed
@NoArgsConstructor(access = PROTECTED)
@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class DepartmentDTO
{
	@NonNull @Setter private String name;

//	/** may be null to indicate that manies are not yet loaded */
//	@EqualsAndHashCode.Exclude
//	private Set<ManyDTO> manies;

	/**
	 * constructor with {@code @NonNull} parameters for each {@code @NonNull} and non {@code final} field, {@link #name}
	 * in this case
	 * <p>use this as common client of this class
	 */
	public DepartmentDTO(@NonNull String name)
	{
		name(name);
	}

	/** let this be used by mapstruct manually map each immutable (no setter) field */
	@MapStructMapper.Default
	public DepartmentDTO(@NonNull DepartmentEntity departmentEntity, @NonNull MapStructMapper.MapStructContext context)
	{
		this(departmentEntity.name());
		log.debug("context {}", context);
		// TODO handle manies

//		if (isNull(departmentEntity.manies()) == false) { manies = new HashSet<>(manies); }
	}
}