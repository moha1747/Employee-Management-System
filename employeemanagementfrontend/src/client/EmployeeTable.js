
import '../styles/home.css'
const EmployeeTable = ({ employees }) => {
  return (
    <table className="table">
      <tbody>
        {employees.map((employee, index) => (
          <tr key={index}>
              <td>
                {employee.firstName}, {employee.lastName} <br />{" "}
                {employee.email}
              </td>
            <td>{employee.position}</td>
            <td>{employee.location}</td>
            <td>{employee.hours}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};
export default EmployeeTable
