import '../App.css';
import React, { useState } from "react";
import axios from "axios";
import SubmissionMessage from "./SubmissionMessage.tsx";


const DeleteEmployeesById: React.FC<{ url: string }> = ({ url }) => {
    const [employeeId, setEmployeeId] = useState<string>('');
    const [message, setMessage] = useState<string>('');
    const [resetKey, setResetKey] = useState<string>('');

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        const username = localStorage.getItem('username');
        const password = localStorage.getItem('password');
        event.preventDefault();
        const form = event.target as HTMLFormElement;

        const authHeader = username && password ? `Basic ${btoa(`${username}:${password}`)}` : undefined;

        try {
            const response = await axios.delete(`http://localhost:8080${url}${employeeId}`, {
                headers: {
                    Authorization: authHeader,
                },
            });
            setMessage(response.data);
            setResetKey(Date.now().toString());
            form.reset();
        } catch (error) {
            setMessage("Please log in")
        }
    };

    const handleEmployeeIdChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setEmployeeId(event.target.value);
    };

    return (
        <div>
            <h2>Delete employee by id</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-input">
                    <label htmlFor="employee-id">Employee id</label>
                    <input
                        value={employeeId}
                        onChange={handleEmployeeIdChange}
                        name="employee-id"
                        type="text"
                        required
                    />
                </div>
                <div className="form-input">
                    <input type="submit" className="button" value="Submit" />
                </div>
            </form>
            <SubmissionMessage key={resetKey} message={message} />
        </div>
    )
}

export default DeleteEmployeesById;
