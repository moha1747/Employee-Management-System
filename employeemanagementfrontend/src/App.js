import { BrowserRouter, Routes, Route } from "react-router-dom";
import AddEmployeeComponent from "./client/AddEmployeeComponent";
import HeaderComponent from "./client/HeaderComponent";
import ListEmployeeComponent from "./client/ListEmployeeComponent";
import Authentication  from "./static/authentication";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Authentication />} />

        <Route path="/employee" element={<HeaderComponent />} />

        <Route path="/employee" element={<ListEmployeeComponent />} />
        <Route path="/add-employee" element={<AddEmployeeComponent />} />
        <Route path="/add-employee/:id" element={<AddEmployeeComponent />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
