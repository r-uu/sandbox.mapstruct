package department_employee_bidirectional;

import static lombok.AccessLevel.PROTECTED;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import department_employee_bidirectional.MapStructMapper.Default;
import department_employee_bidirectional.MapStructMapper.MapStructContext;

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
	 * constructor with {@code @NonNull} parameters for each {@code @NonNull} and non {@code final} field, {@link #name}
	 * in this case
	 * <p>use this as common client of this class
	 */
//	public DepartmentDTO(@NonNull String name)
//	{
//		name(name);
//	}

	/** let this be used by mapstruct (@Default), manually map each immutable (no setter) field */
	@Default public DepartmentDTO(@NonNull DepartmentEntity department, @NonNull MapStructContext context)
	{
		this(department.name());
		log.debug("context {}", context);
		// TODO handle manies

//		if (isNull(department.manies()) == false) { manies = new HashSet<>(manies); }
	}

//	/** return unmodifiable */
//	public Set<Many> manies() { return Set.copyOf(manies); }

//	public boolean add(Many many) { return manies.add(many); }
}