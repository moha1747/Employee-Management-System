import axios from "axios";

const BASE_URL = "http://localhost:8080/user";
class UserService {
  update(userData) {
    return axios.post(`${BASE_URL}/register`, userData);
  }
  delete(id) {
    return axios.delete(`${BASE_URL}/${id}`);
  }
  /**Method to get all employee from our api or database */
  getAllEmplpoyee(id, employeeData) {
    return axios.get(`${BASE_URL}/${id}/employees`, employeeData);
  }
    getEmployeeById(id, employeeData, employeeId) {
            return axios.get(
              `${BASE_URL}/${id}/employees/${employeeId}`,
              employeeData
            );

    }
  addEmployee(id, employeeData) {
    return axios.post(`${BASE_URL}/${id}/employees`, employeeData);
  }
  updateEmployee(id, employeeData, employeeId) {
    return axios.put(`${BASE_URL}/${id}/employees/${employeeId}`, employeeData);
  }
  deleteEmployee(id, employeeData, employeeId) {
    return axios.delete(
      `${BASE_URL}/${id}/employees/${employeeId}`,
      employeeData
    );
      
  }
}
export default new UserService();
// // import axios from "axios";

// const BASEURL = "http://localhost:8080/employee";
// class EmployeeService {
//   //**Method to get all employee from our api or database */
//   getAllEmployee() {
//     return axios.get(BASE_URL);
//   }
//   /**MEthod to save employee */
//   addEmployeeToUser(id, employeeData) {
//     return axios.post(
//       `http://localhost:8080/user/${id}/employee`, id,
//       employeeData
//     );
//   }
//   updateEmployee(id, employeeData) {
//     return axios.put(`${BASE_URL}/${id}`, employeeData);
//   }
//   getEmployeeById(id) {
//     return axios.get(`${BASE_URL}/${id}`);
//   }
//   deleteEmployee(id) {
//     return axios.delete(`${BASE_URL}/${id}`);
//   }
// }
// export default new EmployeeService();
