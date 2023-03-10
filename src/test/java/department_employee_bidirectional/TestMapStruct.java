package department_employee_bidirectional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import department_employee_bidirectional.MapStructMapper.MapStructCycleTrackingContext;
import org.junit.jupiter.api.Test;

class TestMapStruct
{
	@Test void mapEmptyDepartmentDTO()
	{
		DepartmentDTO department = new DepartmentDTO();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(department, new MapStructCycleTrackingContext()));
	}

	@Test void mapEmptyDepartmentEntity()
	{
		DepartmentEntity department = new DepartmentEntity();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(department, new MapStructMapper.MapStructCycleTrackingContext()));
	}

	@Test void mapEmptyEmployeeDTO()
	{
		EmployeeDTO employee = new EmployeeDTO();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(employee, new MapStructCycleTrackingContext()));
	}

	@Test void mapEmptyEmployeeEntity()
	{
		EmployeeEntity employee = new EmployeeEntity();

		assertThrows(NullPointerException.class, () -> MapStructMapper.INSTANCE.map(employee, new MapStructMapper.MapStructCycleTrackingContext()));
	}

	@Test void mapInvalidNamedDepartmentDTO()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new DepartmentDTO(name), new MapStructCycleTrackingContext()));
	}

	@Test void mapInvalidNamedEmployeeDTO()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new EmployeeDTO(name, new DepartmentDTO("name")), new MapStructCycleTrackingContext()));
	}

	@Test void mapInvalidNamedDepartmentEntity()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new DepartmentEntity(name), new MapStructMapper.MapStructCycleTrackingContext()));
	}

	@Test void mapInvalidNamedEmployeeEntity()
	{
		String           name       = null;
		DepartmentEntity department = new DepartmentEntity("name");

		assertThrows(
				NullPointerException.class,
				() -> MapStructMapper.INSTANCE.map(new EmployeeEntity(name, department), new MapStructMapper.MapStructCycleTrackingContext()));
	}

	@Test void mapValidDepartmentDTO()
	{
		String        name       = "name";
		DepartmentDTO department = new DepartmentDTO(name);

		DepartmentEntity departmentEntity = MapStructMapper.INSTANCE.map(department, new MapStructCycleTrackingContext());

		assertThat(departmentEntity          , is(not(nullValue())));
		assertThat(departmentEntity.getName(), is(name));
	}

	@Test void mapValidDepartmentEntity()
	{
		String           name       = "name";
		DepartmentEntity department = new DepartmentEntity(name);

		DepartmentDTO departmentDTO = MapStructMapper.INSTANCE.map(department, new MapStructCycleTrackingContext());

		assertThat(departmentDTO          , is(not(nullValue())));
		assertThat(departmentDTO.getName(), is(name));
	}

	@Test void mapValidEmployeeDTO()
	{
		String         name       = "name";
		DepartmentDTO  department = new DepartmentDTO(name);
		EmployeeDTO    employee   = new EmployeeDTO(name, department);

		EmployeeEntity employeeEntity = MapStructMapper.INSTANCE.map(employee, new MapStructMapper.MapStructCycleTrackingContext());

		assertThat(employeeEntity                          , is(not(nullValue())));
		assertThat(employeeEntity.getName()                , is(name));
		assertThat(employeeEntity.getDepartment().getName(), is(name));
	}

	@Test void mapValidEmployeeEntity()
	{
		String            name       = "name";
		DepartmentEntity  department = new DepartmentEntity(name);
		EmployeeEntity    employee   = new EmployeeEntity(name, department);

		EmployeeDTO employeeDTO = MapStructMapper.INSTANCE.map(employee, new MapStructCycleTrackingContext());

		assertThat(employeeDTO                          , is(not(nullValue())));
		assertThat(employeeDTO.getName()                , is(name));
		assertThat(employeeDTO.getDepartment().getName(), is(name));
	}

	@Test void mapValidDepartmentDTOWithEmployees()
	{
		String        name              = "name";
		DepartmentDTO department        = new DepartmentDTO(name);
		int           numberOfEmployees = 3;

		for (int i = 0; i < numberOfEmployees; i++)
		{
			department.add(new EmployeeDTO("name." + i, department));
		}

		DepartmentEntity departmentEntity = MapStructMapper.INSTANCE.map(department, new MapStructCycleTrackingContext());

		assertThat(departmentEntity                   , is(not(nullValue())));
		assertThat(departmentEntity.employees()       , is(not(nullValue())));
		assertThat(departmentEntity.employees().size(), is(numberOfEmployees));
	}
}