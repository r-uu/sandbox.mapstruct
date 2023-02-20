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
import one2many_bi.MapStructMapper.MapStructContext;

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
	@NonNull @Setter private String name;

//	//may be null
//	@EqualsAndHashCode.Exclude
//	private Set<Many> manies;

	/**
	 * constructor with {@code @NonNull} parameters for each {@code @NonNull} and non {@code final} field, {@link #name}
	 * in this case
	 * <p>use this as common client of this class
	 */
	public EmployeeEntity(@NonNull String name)
	{
		name(name);
	}

	/** let this be used by mapstruct */
	@MapStructMapper.Default
	public EmployeeEntity(@NonNull EmployeeDTO employeeDTO, @NonNull MapStructContext context)
	{
		this(employeeDTO.name());
		log.debug("context {}", context);
		// TODO handle manies
	}

//	/** return unmodifiable */
//	public Set<Many> manies() { return Set.copyOf(manies); }

//	public boolean add(Many many) { return manies.add(many); }
}