package department_employee_bidirectional;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-21T14:34:27+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (GraalVM Community)"
)
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public DepartmentEntity map(DepartmentDTO departmentDTO, MapStructContext context) {
        if ( departmentDTO == null && context == null ) {
            return null;
        }

        MapStructContext context1 = null;
        context1 = context;

        DepartmentDTO department = null;

        DepartmentEntity departmentEntity = new DepartmentEntity( department, context1 );

        return departmentEntity;
    }

    @Override
    public DepartmentDTO map(DepartmentEntity departmentEntity, MapStructContext context) {
        if ( departmentEntity == null && context == null ) {
            return null;
        }

        MapStructContext context1 = null;
        context1 = context;

        DepartmentEntity department = null;

        DepartmentDTO departmentDTO = new DepartmentDTO( department, context1 );

        return departmentDTO;
    }

    @Override
    public EmployeeEntity map(EmployeeDTO employeeDTO, MapStructContext context) {
        if ( employeeDTO == null && context == null ) {
            return null;
        }

        MapStructContext context1 = null;
        context1 = context;

        EmployeeDTO employee = null;

        EmployeeEntity employeeEntity = new EmployeeEntity( employee, context1 );

        return employeeEntity;
    }

    @Override
    public EmployeeDTO map(EmployeeEntity employeeEntity, MapStructContext context) {
        if ( employeeEntity == null && context == null ) {
            return null;
        }

        MapStructContext context1 = null;
        context1 = context;

        EmployeeEntity employee = null;

        EmployeeDTO employeeDTO = new EmployeeDTO( employee, context1 );

        return employeeDTO;
    }
}
