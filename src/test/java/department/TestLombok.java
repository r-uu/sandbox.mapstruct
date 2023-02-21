package department;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestLombok
{
	@Test void emptyDepartmentDTO()
	{
		DepartmentDTO department = new DepartmentDTO();

		assertThat(department.name(), is(nullValue()));
	}

	@Test void emptyDepartmentEntity()
	{
		DepartmentEntity departmentEntity = new DepartmentEntity();

		assertThat(departmentEntity.name(), is(nullValue()));
	}

	@Test void invalidNameDepartmentDTO()
	{
		String name = null;

		assertThrows(NullPointerException.class, () -> new DepartmentDTO(name));
	}


	@Test void invalidNameDepartmentEntity()
	{
		String name = null;

		assertThrows(NullPointerException.class, () -> new DepartmentEntity(name));
	}

	@Test void validDepartmentDTO()
	{
		String name = "name";
		department_employee_bidirectional.DepartmentDTO departmentDTO  = new department_employee_bidirectional.DepartmentDTO(name);

		assertThat(departmentDTO.name(), is(name));
	}
}