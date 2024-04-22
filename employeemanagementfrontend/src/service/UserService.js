import axios from "axios";

const BASE_URL = "http://localhost:8080/user"
class UserService{
    update(userData) {
        return axios.post(`${BASE_URL}/register`, userData);
    }
    delete(id) {
        return axios.delete(`${BASE_URL}/${id}`);
    }

}
export default new UserService();