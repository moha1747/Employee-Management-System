import AddIcon from "@mui/icons-material/Add";
import IconButton from "@mui/material/IconButton";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import "../styles/header.css";

const Header = () => {
  const [isSelected, setSelected] = useState(false);
  return (
    <body>
      <div className="container1">
        <ul className="items__container">
          {/* select all button */}
          <li className="first__label">
            <input
              className="selector"
              type="radio"
              onClick={() => setSelected(!isSelected)}
            />
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
          <li className="fourth__item">Actions</li>
        </ul>
      </div>
    </body>
  );
};

export default Header;
