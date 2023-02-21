package department_employee_bidirectional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import department_employee_bidirectional.MapStructMapper.MapStructContext;
import org.junit.jupiter.api.Test;

class TestMapStruct
{
	@Test void mapEmptyDepartmentDTO()
	{
		DepartmentDTO department = new DepartmentDTO();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(department, new MapStructContext()));
	}

	@Test void mapEmptyDepartmentEntity()
	{
		DepartmentEntity department = new DepartmentEntity();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(department, new MapStructContext()));
	}

	@Test void mapEmptyEmployeeDTO()
	{
		EmployeeDTO employee = new EmployeeDTO();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(employee, new MapStructContext()));
	}

	@Test void mapEmptyEmployeeEntity()
	{
		EmployeeEntity employee = new EmployeeEntity();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(employee, new MapStructContext()));
	}

	@Test void mapInvalidNamedDepartmentDTO()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new DepartmentDTO(name), new MapStructContext()));
	}

	@Test void mapInvalidNamedEmployeeDTO()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new EmployeeDTO(name, new DepartmentDTO("name")), new MapStructContext()));
	}

	@Test void mapInvalidNamedDepartmentEntity()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new DepartmentEntity(name), new MapStructContext()));
	}

	@Test void mapInvalidNamedEmployeeEntity()
	{
		String           name       = null;
		DepartmentEntity department = new DepartmentEntity("name");

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new EmployeeEntity(name, department), new MapStructContext()));
	}

	@Test void mapValidDepartmentDTO()
	{
		String        name       = "name";
		DepartmentDTO department = new DepartmentDTO(name);

		DepartmentEntity departmentEntity = MapStructMapper.INSTANCE.map(department, new MapStructContext());

		assertThat(departmentEntity       , is(not(nullValue())));
		assertThat(departmentEntity.name(), is(name));
	}

	@Test void mapValidDepartmentEntity()
	{
		String           name       = "name";
		DepartmentEntity department = new DepartmentEntity(name);

		DepartmentDTO departmentDTO = MapStructMapper.INSTANCE.map(department, new MapStructContext());

		assertThat(departmentDTO       , is(not(nullValue())));
		assertThat(departmentDTO.name(), is(name));
	}

	@Test void mapValidEmployeeDTO()
	{
		String         name       = "name";
		DepartmentDTO  department = new DepartmentDTO(name);
		EmployeeDTO    employee   = new EmployeeDTO(name, department);

		EmployeeEntity employeeEntity = MapStructMapper.INSTANCE.map(employee, new MapStructContext());

		assertThat(employeeEntity                    , is(not(nullValue())));
		assertThat(employeeEntity.name()             , is(name));
		assertThat(employeeEntity.department().name(), is(name));
	}

	@Test void mapValidEmployeeEntity()
	{
		String            name       = "name";
		DepartmentEntity  department = new DepartmentEntity(name);
		EmployeeEntity    employee   = new EmployeeEntity(name, department);

		EmployeeDTO employeeDTO = MapStructMapper.INSTANCE.map(employee, new MapStructContext());

		assertThat(employeeDTO                    , is(not(nullValue())));
		assertThat(employeeDTO.name()             , is(name));
		assertThat(employeeDTO.department().name(), is(name));
	}
}