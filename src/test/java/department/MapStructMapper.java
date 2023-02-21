package department;

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

	DepartmentEntity map(DepartmentDTO    department, MapStructContext context);
	DepartmentDTO    map(DepartmentEntity department, MapStructContext context);

	@ObjectFactory default DepartmentDTO create(
			@NonNull DepartmentEntity department, @NonNull @Context MapStructContext context)
	{
		return new DepartmentDTO(department, context);
	}

	@ObjectFactory default DepartmentEntity create(
			@NonNull DepartmentDTO department, @NonNull @Context MapStructContext context)
	{
		return new DepartmentEntity(department, context);
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