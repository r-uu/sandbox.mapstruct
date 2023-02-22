package department_employee_bidirectional;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-22T15:29:44+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (GraalVM Community)"
)
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public DepartmentEntity map(DepartmentDTO department, MapStructCycleTrackingContext context) {
        if ( department == null && context == null ) {
            return null;
        }

        MapStructCycleTrackingContext context1 = null;
        context1 = context;

        DepartmentDTO department1 = null;

        DepartmentEntity departmentEntity = new DepartmentEntity( department1, context1 );

        if ( department != null ) {
            departmentEntity.setName( department.getName() );
            if ( departmentEntity.getEmployees() != null ) {
                Set<EmployeeEntity> set = employeeDTOSetToEmployeeEntitySet( department.getEmployees() );
                if ( set != null ) {
                    departmentEntity.getEmployees().addAll( set );
                }
            }
        }

        return departmentEntity;
    }

    @Override
    public DepartmentDTO map(DepartmentEntity department, MapStructCycleTrackingContext context) {
        if ( department == null && context == null ) {
            return null;
        }

        MapStructCycleTrackingContext context1 = null;
        context1 = context;

        DepartmentEntity department1 = null;

        DepartmentDTO departmentDTO = new DepartmentDTO( department1, context1 );

        if ( department != null ) {
            departmentDTO.setName( department.getName() );
            if ( departmentDTO.getEmployees() != null ) {
                Set<EmployeeDTO> set = employeeEntitySetToEmployeeDTOSet( department.getEmployees() );
                if ( set != null ) {
                    departmentDTO.getEmployees().addAll( set );
                }
            }
        }

        return departmentDTO;
    }

    @Override
    public EmployeeEntity map(EmployeeDTO employee, MapStructCycleTrackingContext context) {
        if ( employee == null && context == null ) {
            return null;
        }

        MapStructCycleTrackingContext context1 = null;
        context1 = context;

        EmployeeDTO employee1 = null;

        EmployeeEntity employeeEntity = new EmployeeEntity( employee1, context1 );

        if ( employee != null ) {
            employeeEntity.setName( employee.getName() );
            employeeEntity.setDepartment( departmentDTOToDepartmentEntity( employee.getDepartment() ) );
        }

        return employeeEntity;
    }

    @Override
    public EmployeeDTO map(EmployeeEntity employee, MapStructCycleTrackingContext context) {
        if ( employee == null && context == null ) {
            return null;
        }

        MapStructCycleTrackingContext context1 = null;
        context1 = context;

        EmployeeEntity employee1 = null;

        EmployeeDTO employeeDTO = new EmployeeDTO( employee1, context1 );

        if ( employee != null ) {
            employeeDTO.setName( employee.getName() );
        }

        return employeeDTO;
    }

    protected Set<EmployeeEntity> employeeDTOSetToEmployeeEntitySet(Set<EmployeeDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<EmployeeEntity> set1 = new LinkedHashSet<EmployeeEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( EmployeeDTO employeeDTO : set ) {
            set1.add( employeeDTOToEmployeeEntity( employeeDTO ) );
        }

        return set1;
    }

    protected DepartmentEntity departmentDTOToDepartmentEntity(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        DepartmentDTO department = null;
        MapStructCycleTrackingContext context = null;

        DepartmentEntity departmentEntity = new DepartmentEntity( department, context );

        departmentEntity.setName( departmentDTO.getName() );
        if ( departmentEntity.getEmployees() != null ) {
            Set<EmployeeEntity> set = employeeDTOSetToEmployeeEntitySet( departmentDTO.getEmployees() );
            if ( set != null ) {
                departmentEntity.getEmployees().addAll( set );
            }
        }

        return departmentEntity;
    }

    protected EmployeeEntity employeeDTOToEmployeeEntity(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        EmployeeDTO employee = null;
        MapStructCycleTrackingContext context = null;

        EmployeeEntity employeeEntity = new EmployeeEntity( employee, context );

        employeeEntity.setName( employeeDTO.getName() );
        employeeEntity.setDepartment( departmentDTOToDepartmentEntity( employeeDTO.getDepartment() ) );

        return employeeEntity;
    }

    protected EmployeeDTO employeeEntityToEmployeeDTO(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        EmployeeEntity employee = null;
        MapStructCycleTrackingContext context = null;

        EmployeeDTO employeeDTO = new EmployeeDTO( employee, context );

        employeeDTO.setName( employeeEntity.getName() );

        return employeeDTO;
    }

    protected Set<EmployeeDTO> employeeEntitySetToEmployeeDTOSet(Set<EmployeeEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<EmployeeDTO> set1 = new LinkedHashSet<EmployeeDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( EmployeeEntity employeeEntity : set ) {
            set1.add( employeeEntityToEmployeeDTO( employeeEntity ) );
        }

        return set1;
    }
}
