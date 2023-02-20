package one2many_bi;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestLombok
{
	@Test void emptyDepartmentDTO()
	{
		DepartmentDTO departmentDTO = new DepartmentDTO();

		assertThat(departmentDTO.name(), is(nullValue()));
	}

	@Test void emptyEmployeeDTO()
	{
		EmployeeDTO employeeDTO = new EmployeeDTO();

		assertThat(employeeDTO.name(), is(nullValue()));
	}

	@Test void emptyDepartmentEntity()
	{
		DepartmentEntity departmentEntity = new DepartmentEntity();

		assertThat(departmentEntity.name(), is(nullValue()));
	}

	@Test void emptyEmployeeEntity()
	{
		EmployeeEntity employeeEntity = new EmployeeEntity();

		assertThat(employeeEntity.name(), is(nullValue()));
	}

	@Test void invalidNameDepartmentDTO()
	{
		String name = null;

		assertThrows(NullPointerException.class, () -> new DepartmentDTO(name));
	}

	@Test void invalidNameEmployeeDTO()
	{
		String name = null;

		assertThrows(NullPointerException.class, () -> new EmployeeDTO(name));
	}

	@Test void invalidNameDepartmentEntity()
	{
		String name = null;

		assertThrows(NullPointerException.class, () -> new DepartmentEntity(name));
	}

	@Test void invalidNameEmployeeEntity()
	{
		String name = null;

		assertThrows(NullPointerException.class, () -> new EmployeeEntity(name));
	}

	@Test void namedDepartmentDTO()
	{
		String name = "name";
		DepartmentDTO departmentDTO  = new DepartmentDTO(name);

		assertThat(departmentDTO.name(), is(name));
	}

	@Test void namedEmployeeDTO()
	{
		String name = "name";
		EmployeeDTO employeeDTO  = new EmployeeDTO(name);

		assertThat(employeeDTO.name()  , is(name));
	}
}