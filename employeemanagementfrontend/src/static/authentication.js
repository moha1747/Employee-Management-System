import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
import AuthenticationService from '../service/AuthenticationService'
import '../styles/auth.css'

export const Authentication = () => {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [isRegister, setRegister] = useState(false);
    const navigate = useNavigate();
    const userData = {
        email,
        password
    }
    function switchCard() {
      const loginCard = document.querySelector(".container .card:nth-child(1)");
      const registerCard = document.querySelector(
        ".container .card:nth-child(2)"
      );

      if (loginCard.style.display === "none") {
        loginCard.style.display = "block";
        registerCard.style.display = "none";
      } else {
        loginCard.style.display = "none";
        registerCard.style.display = "block";
      }
    }

    function saveUser(e) {
        e.preventDefault();
        if (Object.values(userData).every((field) => field !== "")) {
            if (!isRegister) {
                AuthenticationService.login(userData)
                    .then(() => navigate("/employees"))
                .catch((e) => console.log(e))
            }
            AuthenticationService.register(userData)
                .then(() => navigate("/employees"))
                .catch((e) => console.log(e))
        } else {
            alert("Please fill in all fields")
        }
  }
  return (
 <div className="container">
  <div className="card">
    <h2>Login Form</h2>
    <form>
      <label for="email">Email</label>
      <input type="text" id="email" placeholder="Enter your Email" />

      <label for="password">Password</label>
      <input type="password" id="password" placeholder="Enter your password" onChange={(e) => setEmail(e.target.value)}/>

      <button type="submit">Login</button>
    </form>
    <div className="switch">Don't have an account? <Link onclick={switchCard()}>Register here</Link></div>
  </div>

  <div className="card" style={{display: "none"}}>
    <h2>Register Form</h2>
    <form>
      <label for="fullname">Full Name</label>
      <input type="text" id="fullname" placeholder="Enter your full name" />

      <label for="email">Email</label>
      <input type="email" id="email" placeholder="Enter your email" />

      <label for="new-password">New Password</label>
      <input type="password" id="new-password" placeholder="Enter your new password" />

      <button type="submit">Register</button>
    </form>
              <div className="switch">Already have an account? <Link onclick={switchCard()}>Login here</Link></div>
  </div>
</div>
  );
}
export default Authentication
