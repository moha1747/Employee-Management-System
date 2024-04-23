import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import AuthenticationService from "../service/AuthenticationService";
import "../styles/auth.css";

const Authentication = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isRegister, setRegister] = useState(false);
  const navigate = useNavigate();
  const userData = {
    email,
    password
  }

  function handleLogin(e) {
    e.preventDefault();
    if (email !== "" && password !== "") {
      AuthenticationService.login(userData)
        .then(() => navigate("/employee"))
        .catch((e) => console.log(e));
      console.log(userData)
    } else {
      alert("Please fill in all fields");
    }
  }

  function handleRegister(e) {
    e.preventDefault();
    if (email !== "" && password !== "") {
      AuthenticationService.register(userData)
        .then(() => navigate("/employee"))
        .catch((e) => console.log(e));
            console.log(userData);

    } else {
      alert("Please fill in all fields");
    }
  }

  function switchCard() {
    setRegister(!isRegister);
  }

  return (
    <div className="container">
      {isRegister ? (
        <div className="card">
          <h2>Register Form</h2>
          <form onSubmit={handleRegister}>
            <label htmlFor="email">Email</label>
            <input
              type="email"
              id="email"
              value={email}
              placeholder="Enter your email"
              onChange={(e) => setEmail(e.target.value)}
            />

            <label htmlFor="new-password">New Password</label>
            <input
              value={password}
              type="password"
              id="new-password"
              placeholder="Enter your new password"
              onChange={(e) => setPassword(e.target.value)}
            />
            
            <button onClick={(e) => handleRegister(e)}>Register</button>
          </form>
          <div className="switch">
            Already have an account?{" "}
            <Link to="#" onClick={switchCard}>
              Login here
            </Link>
          </div>
        </div>
      ) : (
        <div className="card">
          <h2>Login Form</h2>
          <form onSubmit={handleLogin}>
            <label htmlFor="email">Email</label>
            <input
              type="email"
              id="email"
              placeholder="Enter your Email"
              onChange={(e) => setEmail(e.target.value)}
            />

            <label htmlFor="password">Password</label>
            <input
              type="password"
              id="password"
              placeholder="Enter your password"
              onChange={(e) => setPassword(e.target.value)}
            />

            <button onClick={(e) => handleLogin(e)}>Login</button>
          </form>
          <div className="switch">
            Don't have an account?{" "}
            <Link to="#" onClick={switchCard}>
              Register here
            </Link>
          </div>
        </div>
      )}
    </div>
  );
};

export default Authentication;
