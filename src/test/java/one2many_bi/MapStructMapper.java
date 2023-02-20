package one2many_bi;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.IdentityHashMap;
import java.util.Map;
import lombok.NonNull;
import lombok.ToString;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructMapper
{
	MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

	DepartmentEntity map(DepartmentDTO departmentDTO, MapStructContext context);
	DepartmentDTO map(DepartmentEntity departmentEntity, MapStructContext context);

	EmployeeEntity map(EmployeeDTO departmentDTO, MapStructContext context);
	EmployeeDTO map(EmployeeEntity departmentEntity, MapStructContext context);

	@ObjectFactory default DepartmentDTO create(
			@NonNull DepartmentEntity departmentEntity, @NonNull @Context MapStructContext context)
	{
		return new DepartmentDTO(departmentEntity, context);
	}

	@ObjectFactory default DepartmentEntity create(
			@NonNull DepartmentDTO departmentDTO, @NonNull @Context MapStructContext context)
	{
		return new DepartmentEntity(departmentDTO, context);
	}

	@ObjectFactory default EmployeeDTO create(
			@NonNull EmployeeEntity employeeEntity, @NonNull @Context MapStructContext context)
	{
		return new EmployeeDTO(employeeEntity, context);
	}

	@ObjectFactory default EmployeeEntity create(
			@NonNull EmployeeDTO employeeDTO, @NonNull @Context MapStructContext context)
	{
		return new EmployeeEntity(employeeDTO, context);
	}

	@ToString
	class MapStructContext
	{
		private Map<Object, Object> knownInstances = new IdentityHashMap<Object, Object>();

		@BeforeMapping
		public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {
			return (T) knownInstances.get( source );
		}

		@BeforeMapping
		public void storeMappedInstance(Object source, @MappingTarget Object target) {
			knownInstances.put( source, target );
		}
	}

	@Target({CONSTRUCTOR})
	@Retention(CLASS)
	@interface Default { }
}