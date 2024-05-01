import "../styles/home.css";
import EditIcon from "@mui/icons-material/Edit";
import DeleteOutlineIcon from "@mui/icons-material/DeleteOutline";
import IconButton from "@mui/material/IconButton";
import { Link, useNavigate } from "react-router-dom";
import UserService from "../service/UserService";


const BASE_URL = "http://localhost:8080/user";
const userId = localStorage.getItem("userId");




const EmployeeTable = ({ employees }) => {

  const deleteEmployee = (userId, employeeId) => {
    UserService.deleteEmployee(userId, employeeId)
      .then(() => {
        window.location.reload();
        console.log("Employee deleted successfully");
      })
      .catch((error) => {
        console.error("Failed to delete employee:", error);
      });
  };


  return (
    <div className="tableContainer">
      <table className="table">
        <tbody>
          {employees.map((employee, index) => (
            <tr key={index}>
              <td className="employeeName">
                {employee.firstName}, {employee.lastName}
                <br />
                {employee.email}
              </td>
              <td className="position">{employee.position}</td>
              <td className="location">{employee.location}</td>
              <td className="hours">{employee.hours}</td>
              <td className="actions">
                {/* Placeholder for action buttons or links */}
                <Link to={`/add-employee/${employee.id}`}>
                  <IconButton>
                    <EditIcon />
                  </IconButton>
                </Link>

                <IconButton onClick={() => deleteEmployee(userId, employee.id)}>
                  <DeleteOutlineIcon />
                </IconButton>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EmployeeTable;
