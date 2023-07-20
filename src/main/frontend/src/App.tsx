import './App.css'
import AddEmployee from "./components/AddEmployee.tsx";
import DisplayAllEmployees from "./components/DisplayAllEmployees.tsx";
import SearchEmployeesById from "./components/SearchEmployeesById.tsx";
import DeleteEmployeeById from "./components/DeleteEmployeeById.tsx";
import Login from "./components/Login.component.tsx";
import UpdateEmployee from "./components/UpdateEmployee.tsx";

function App() {
    return (
    <div>
        <Login />
        <h1 className="title" id="memory">In-Memory Employee Management</h1>
        <div className="parent">
            <div className="div1">
                <AddEmployee url="/api/v1/no-auth/employees/save" />
            </div>
            <div className="div2">
                <DisplayAllEmployees url="/api/v1/no-auth/employees/get/all" />
            </div>
            <div className="div3">
                <SearchEmployeesById url="/api/v1/no-auth/employees/get/" />
            </div>
            <div className="div4">
                <UpdateEmployee url="/api/v1/no-auth/employees/update/" />
            </div>
            <div className="div5"></div>
            <div className="div6">
                <DeleteEmployeeById url="/api/v1/no-auth/employees/delete/" />
            </div>
        </div>
        <div>
            <h1 className="title" id="database">
                Database Employee Management
            </h1>
            <div className="parent">
                <div className="div1">
                    <AddEmployee url="/api/v1/auth/emp/save" />
                </div>
                <div className="div2">
                    <DisplayAllEmployees url="/api/v1/auth/emp/get/all" />
                </div>
                <div className="div3">
                    <SearchEmployeesById url="/api/v1/auth/emp/get/" />
                </div>
                <div className="div4">
                    <UpdateEmployee url="/api/v1/auth/emp/update/" />
                </div>
                <div className="div5"></div>
                <div className="div6">
                    <DeleteEmployeeById url="/api/v1/auth/emp/delete/" />
                </div>
            </div>
        </div>
    </div>
  )
}

export default App
