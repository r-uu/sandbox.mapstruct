package one2many_bi;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import one2many_bi.MapStructMapper.MapStructContext;
import org.junit.jupiter.api.Test;

class TestMapStruct
{
	@Test void mapEmptyDepartmentDTO()
	{
		DepartmentDTO departmentDTO = new DepartmentDTO();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(departmentDTO, new MapStructContext()));
	}

	@Test void mapEmptyEmployeeDTO()
	{
		EmployeeDTO employeeDTO = new EmployeeDTO();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(employeeDTO, new MapStructContext()));
	}

	@Test void invalidNameDepartmentEntity()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new DepartmentEntity(name), new MapStructContext()));
	}

	@Test void invalidNameEmployeeEntity()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new EmployeeEntity(name), new MapStructContext()));
	}

	@Test void mapNamedDepartmentDTOWithoutEmployees()
	{
		String name = "name";
		DepartmentDTO departmentDTO = new DepartmentDTO(name);
		DepartmentEntity departmentEntity = MapStructMapper.INSTANCE.map(departmentDTO, new MapStructContext());

		assertThat(departmentEntity       , is(not(nullValue())));
		assertThat(departmentEntity.name(), is(name));
	}

	@Test void mapNamedEmployeeDTO()
	{
		String name = "name";
		EmployeeDTO employeeDTO = new EmployeeDTO(name);
		EmployeeEntity employeeEntity = MapStructMapper.INSTANCE.map(employeeDTO, new MapStructContext());

		assertThat(employeeEntity       , is(not(nullValue())));
		assertThat(employeeEntity.name(), is(name));
	}
}