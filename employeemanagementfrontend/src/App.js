import { BrowserRouter, Routes, Route } from "react-router-dom";
import AddEmployeeComponent from "./component/AddEmployeeComponent";
import HeaderComponent from "./component/HeaderComponent";
import ListEmployeeComponent from "./component/ListEmployeeComponent";

function App() {
  return (
    <BrowserRouter>
      <HeaderComponent />

      <Routes>
        <Route path="/" element={<ListEmployeeComponent />} />
        <Route path="/employee" element={<ListEmployeeComponent />} />
        <Route path="/add-employee" element={<AddEmployeeComponent />} />
        <Route path="/add-employee/:id" element={<AddEmployeeComponent />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
