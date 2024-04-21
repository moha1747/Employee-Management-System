import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
import UserService from '../service/UserService'

export const Authentication = () => {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const navigate = useNavigate();
    const userData = {
        email,
        password
    }

    function saveUser(e) {
        e.preventDefault();
        if (Object.values(userData).every((field) => field !== "")) {
            UserService.saveUser(userData)
                .then(() => navigate("/employees"))
                .catch((e) => console.log(e))
        } else {
            alert("Please fill in all fields")
        }
  }
  return (
    <div>
      <div className="container1">
        <div className="title">
          <h2>Register</h2>
          {/* or login, do this later just check functionality now */}
        </div>
        <div className="card-body">
          <form>
            <div className="form-group">
              <input
                className="form-control"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                type="text"
                placeholder="Enter your email"
              />
            </div>
            <div className="form-group mb-2">
              <input
                className="form-control"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                type="password"
                placeholder="Enter your password"
              />
            </div>
            <Link to={"/employee"} style={{ textDecoration: "none" }} href="">
              <button onClick={(e) => saveUser(e)} className="custom-btn btn-5">
                {" "}
                <span>Register</span>
              </button>
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
export default Authentication