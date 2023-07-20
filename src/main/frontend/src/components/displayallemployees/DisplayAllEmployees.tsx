import './styles.css'
import React, { useState } from "react";
import axios from "axios";

const DisplayAllEmployees: React.FC<{ url: string }> = ({ url }) => {
    const [employees, setEmployees] = useState<string>('');

    const getAllEmployees = async () => {
        const username = localStorage.getItem('username');
        const password = localStorage.getItem('password');

        const authHeader = username && password ? `Basic ${btoa(`${username}:${password}`)}` : undefined;

        try {
            const response = await axios.get(`http://localhost:8080${url}`, {
                headers: {
                    Authorization: authHeader,
                },
            });
            if (response.status === 200) {
                const employeesData = await response.data;
                setEmployees(JSON.stringify(employeesData, undefined, 2));
            }
        } catch (error) {
            setEmployees("Please log in")
        }
    };

    return (
        <div>
            <h2>Display all employees</h2>
            <textarea value={employees} readOnly />
            <button className="display-button" onClick={getAllEmployees}>
                Display
            </button>
        </div>
    );
};

export default DisplayAllEmployees;