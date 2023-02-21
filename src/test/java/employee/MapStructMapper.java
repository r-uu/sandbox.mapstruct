package employee;

import lombok.NonNull;
import lombok.ToString;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.IdentityHashMap;
import java.util.Map;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.CLASS;

@Mapper
public interface MapStructMapper
{
	MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

	EmployeeEntity map(EmployeeDTO department, MapStructContext context);
	EmployeeDTO map(EmployeeEntity department, MapStructContext context);

	@ObjectFactory default EmployeeDTO create(
			@NonNull EmployeeEntity department, @NonNull @Context MapStructContext context)
	{
		return new EmployeeDTO(department, context);
	}

	@ObjectFactory default EmployeeEntity create(
			@NonNull EmployeeDTO department, @NonNull @Context MapStructContext context)
	{
		return new EmployeeEntity(department, context);
	}

	@ToString class MapStructContext
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