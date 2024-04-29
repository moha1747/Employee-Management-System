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
  getAllEmployee(id, employeeData) {
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
