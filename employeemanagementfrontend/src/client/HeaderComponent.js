import AddIcon from "@mui/icons-material/Add";
import IconButton from "@mui/material/IconButton";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../styles/header.css";
import LogoutIcon from "@mui/icons-material/Logout";
import Logout from "@mui/icons-material/Logout";
import AuthenticationService from "../service/AuthenticationService";


const Header = () => {
  const [isSelected, setSelected] = useState(false);
  const navigate = useNavigate();

  const logout = () => {
    AuthenticationService.logout()
      .then(() => {
        localStorage.removeItem("userId");

        navigate("/"); // Navigate to login page after logout
      })
      .catch((error) => {
        console.error("Logout failed:", error);
      });
  };
  return (
    <body>
      <div className="container1">
        <ul className="items__container">
          {/* select all button */}
          <li className="first__label">
            <Link to={"/employee"} style={{ textDecoration: "none" }}>
              {" "}
              <label className="employee">Employee</label>
            </Link>
            <IconButton href="/add-employee">
              <AddIcon style={{ color: "white" }} />
            </IconButton>
          </li>

          <li className="second__item">Position</li>
          <li className="third__item">Location</li>
          <li className="fourth__item">Hours</li>
          <li className="fifth__item">Actions</li>
          <IconButton onClick={logout}> 
            <LogoutIcon style={{ color: "white"}}/>
          </IconButton>
        </ul>
      </div>
    </body>
  );
};

export default Header;
