package employee;

import employee.MapStructMapper.MapStructContext;
import org.junit.jupiter.api.Test;

import static employee.MapStructMapper.INSTANCE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestMapStruct
{
	@Test void mapEmptyemployeeDTO()
	{
		EmployeeDTO employee = new EmployeeDTO();

		assertThrows(NullPointerException.class, () -> INSTANCE.map(employee, new MapStructContext()));
	}

	@Test void mapEmptyemployeeEntity()
	{
		EmployeeEntity employee = new EmployeeEntity();

		assertThrows(NullPointerException.class, () -> INSTANCE.map(employee, new MapStructContext()));
	}

	@Test void mapInvalidNamedemployeeDTO()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> INSTANCE.map(new EmployeeDTO(name), new MapStructContext()));
	}

	@Test void mapInvalidNamedemployeeEntity()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> INSTANCE.map(new EmployeeEntity(name), new MapStructContext()));
	}

	@Test void mapValidemployeeDTO()
	{
		String        name       = "name";
		EmployeeDTO employee = new EmployeeDTO(name);

		EmployeeEntity employeeEntity = INSTANCE.map(employee, new MapStructContext());

		assertThat(employeeEntity, is(not(nullValue())));
		assertThat(employeeEntity.name(), is(name));
	}

	@Test void mapValidemployeeEntity()
	{
		String           name       = "name";
		EmployeeEntity employee = new EmployeeEntity(name);

		EmployeeDTO employeeDTO = INSTANCE.map(employee, new MapStructContext());

		assertThat(employeeDTO, is(not(nullValue())));
		assertThat(employeeDTO.name(), is(name));
	}
}