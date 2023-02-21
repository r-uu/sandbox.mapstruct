package employee;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestLombok
{
	@Test void emptyemployeeDTO()
	{
		EmployeeDTO employee = new EmployeeDTO();

		assertThat(employee.name(), is(nullValue()));
	}

	@Test void emptyemployeeEntity()
	{
		EmployeeEntity employeeEntity = new EmployeeEntity();

		assertThat(employeeEntity.name(), is(nullValue()));
	}

	@Test void invalidNameemployeeDTO()
	{
		String name = null;

		assertThrows(NullPointerException.class, () -> new EmployeeDTO(name));
	}


	@Test void invalidNameemployeeEntity()
	{
		String name = null;

		assertThrows(NullPointerException.class, () -> new EmployeeEntity(name));
	}

	@Test void validemployeeDTO()
	{
		String name = "name";
		EmployeeDTO employeeDTO  = new EmployeeDTO(name);

		assertThat(employeeDTO.name(), is(name));
	}
}