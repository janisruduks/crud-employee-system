import './App.css'
import AddEmployee from "./components/employeeaddform/addEmployee.tsx";
import DisplayAllEmployees from "./components/displayallemployees/DisplayAllEmployees.tsx";
import SearchEmployeesById from "./components/searchemployeebyid/SearchEmployeesById.tsx";
import DeleteEmployeeById from "./components/deleteemployeebyid/DeleteEmployeeById.tsx";
import Login from "./components/login/Login.component.tsx";

function App() {
    return (
    <div>
        <Login />
        <h1 className="title" id="memory">In-Memory Employee Management</h1>
        <div className="parent">
            <div className="div1">
                <AddEmployee url="/api/v1/employees/save" />
            </div>
            <div className="div2">
                <DisplayAllEmployees url="/api/v1/employees/get/all" />
            </div>
            <div className="div3">
                <SearchEmployeesById url="/api/v1/employees/get/" />
            </div>
            <div className="div4">
                <DeleteEmployeeById url="/api/v1/employees/delete/" />
            </div>
        </div>
        <div>
            <h1 className="title" id="database">
                Database Employee Management
            </h1>
            <div className="parent">
                <div className="div1">
                    <AddEmployee url="/api/v1/emp/save" />
                </div>
                <div className="div2">
                    <DisplayAllEmployees url="/api/v1/emp/get/all" />
                </div>
                <div className="div3">
                    <SearchEmployeesById url="/api/v1/emp/get/" />
                </div>
                <div className="div4">
                    <DeleteEmployeeById url="/api/v1/emp/delete/" />
                </div>
            </div>
        </div>
    </div>
  )
}

export default App