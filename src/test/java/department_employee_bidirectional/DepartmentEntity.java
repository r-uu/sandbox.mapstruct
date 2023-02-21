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
	 * constructor with {@code @NonNull} parameters for each {@code @NonNull} and non {@code final} field, {@link #name}
	 * in this case
	 * <p>use this as common client of this class
	 */
	public DepartmentEntity(@NonNull String name)
	{
		name(name);
	}

	/** let this be used by mapstruct (@Default), manually map each immutable (no setter) field */
	@MapStructMapper.Default
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