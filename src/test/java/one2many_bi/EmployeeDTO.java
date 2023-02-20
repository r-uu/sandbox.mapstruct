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
import one2many_bi.MapStructMapper.Default;

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
	@NonNull @Setter private String name;

//	/** may be null to indicate that manies are not yet loaded */
//	@EqualsAndHashCode.Exclude
//	private Set<ManyDTO> manies;

	/**
	 * constructor with {@code @NonNull} parameters for each {@code @NonNull} and non {@code final} field, {@link #name}
	 * in this case
	 * <p>use this as common client of this class
	 */
	public EmployeeDTO(@NonNull String name)
	{
		name(name);
	}

	/** let this be used by mapstruct manually map each immutable (no setter) field */
	@Default
	public EmployeeDTO(@NonNull EmployeeEntity employeeEntity, @NonNull MapStructMapper.MapStructContext context)
	{
		this(employeeEntity.name());
		log.debug("context {}", context);
		// TODO handle manies

//		if (isNull(departmentEntity.manies()) == false) { manies = new HashSet<>(manies); }
	}
}