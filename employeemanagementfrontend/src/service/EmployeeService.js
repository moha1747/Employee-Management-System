import axios from "axios";

const BASE_URL = "http://localhost:8080/employee";
class EmployeeService {
  //**Method to get all employee from our api or database */
  getAllEmployee() {
    return axios.get(BASE_URL);
  }
  /**MEthod to save employee */
  addEmployeeToUser(userId, employeeData) {
    return axios.post(
      `http://localhost:8080/user/${userId}/employees`,
      employeeData
    );
  }
  updateEmployee(id, employeeData) {
    return axios.put(`${BASE_URL}/${id}`, employeeData);
  }
  getEmployeeById(id) {
    return axios.get(`${BASE_URL}/${id}`);
  }
  deleteEmployee(id) {
    return axios.delete(`${BASE_URL}/${id}`);
  }
}
export default new EmployeeService();