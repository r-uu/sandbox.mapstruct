package department;

import static department.MapStructMapper.INSTANCE;
import static department.MapStructMapper.MapStructContext;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestMapStruct
{
	@Test void mapEmptyDepartmentDTO()
	{
		DepartmentDTO department = new DepartmentDTO();

		assertThrows(NullPointerException.class, () -> INSTANCE.map(department, new MapStructContext()));
	}

	@Test void mapEmptyDepartmentEntity()
	{
		DepartmentEntity department = new DepartmentEntity();

		assertThrows(NullPointerException.class, () -> INSTANCE.map(department, new MapStructContext()));
	}

	@Test void mapInvalidNamedDepartmentDTO()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> INSTANCE.map(new DepartmentDTO(name), new MapStructContext()));
	}

	@Test void mapInvalidNamedDepartmentEntity()
	{
		String name = null;

		assertThrows(
				NullPointerException.class,
				() -> INSTANCE.map(new DepartmentEntity(name), new MapStructContext()));
	}

	@Test void mapValidDepartmentDTO()
	{
		String        name       = "name";
		DepartmentDTO department = new DepartmentDTO(name);

		DepartmentEntity departmentEntity = INSTANCE.map(department, new MapStructContext());

		assertThat(departmentEntity       , is(not(nullValue())));
		assertThat(departmentEntity.name(), is(name));
	}

	@Test void mapValidDepartmentEntity()
	{
		String           name       = "name";
		DepartmentEntity department = new DepartmentEntity(name);

		DepartmentDTO departmentDTO = INSTANCE.map(department, new MapStructContext());

		assertThat(departmentDTO       , is(not(nullValue())));
		assertThat(departmentDTO.name(), is(name));
	}
}