import '../App.css';
import React, {useState} from "react";
import axios from "axios";

const SearchEmployeesById: React.FC<{ url: string }> = ({ url }) => {
    const [employeeId, setEmployeeId] = useState<string>('');
    const [employee, setEmployee] = useState<string>('');

    const getEmployeeById = async () => {
        const username = localStorage.getItem('username');
        const password = localStorage.getItem('password');

        const authHeader = username && password ? `Basic ${btoa(`${username}:${password}`)}` : undefined;

        try {
            const response = await axios.get(`http://localhost:8080${url}${employeeId}`, {
                headers: {
                    Authorization: authHeader,
                },
            });
            const employeeData = await response.data;
            setEmployee(JSON.stringify(employeeData));
        } catch (error) {
            setEmployee('Not found');
        }
    };

    const handleEmployeeIdChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setEmployeeId(event.target.value);
    };

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        getEmployeeById();
    };

    return (
        <div>
            <h2>Search by employee id</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-input">
                    <label htmlFor="employee-id">Employee id</label>
                    <input value={employeeId} onChange={handleEmployeeIdChange} name="employee-id" type="text" required />
                </div>
                <div className="form-input">
                    <input type="submit" className="button" value="Submit" />
                </div>
            </form>
            <textarea className="text-area" value={employee} readOnly />
        </div>
    )
}

export default SearchEmployeesById;