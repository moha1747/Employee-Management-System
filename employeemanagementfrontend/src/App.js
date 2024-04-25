import { BrowserRouter, Routes, Route } from "react-router-dom";
import AddEmployeeComponent from "./client/AddEmployeeComponent";
import HeaderComponent from "./client/HeaderComponent";
import ListEmployeeComponent from "./client/ListEmployeeComponent";
import Authentication from "./static/authentication";
// const userId = localStorage.getItem('userId')
// const employeeId = localStorage.getItem('employeeID')

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Authentication />} />

        <Route path="/user/employee" element={<HeaderComponent />} />

        <Route path="/user/employee" element={<ListEmployeeComponent />} />
        <Route path="/add-employee" element={<AddEmployeeComponent />} />
        <Route path="/add-employee/:id" element={<AddEmployeeComponent />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
