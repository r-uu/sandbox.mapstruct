package department;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-21T14:34:27+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (GraalVM Community)"
)
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public DepartmentEntity map(DepartmentDTO department, MapStructContext context) {
        if ( department == null && context == null ) {
            return null;
        }

        DepartmentDTO department1 = null;
        department1 = department;
        MapStructContext context1 = null;
        context1 = context;

        DepartmentEntity departmentEntity = new DepartmentEntity( department1, context1 );

        return departmentEntity;
    }

    @Override
    public DepartmentDTO map(DepartmentEntity department, MapStructContext context) {
        if ( department == null && context == null ) {
            return null;
        }

        DepartmentEntity department1 = null;
        department1 = department;
        MapStructContext context1 = null;
        context1 = context;

        DepartmentDTO departmentDTO = new DepartmentDTO( department1, context1 );

        return departmentDTO;
    }
}
