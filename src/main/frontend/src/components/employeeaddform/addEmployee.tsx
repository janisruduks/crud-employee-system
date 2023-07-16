import axios from 'axios';
import './styles.css';
import React, { useState } from "react";
import SubmissionMessage from "../submisionmessage/SubmissionMessage.tsx";

const AddEmployee: React.FC<{url:string}> = ({url}) => {
    const [message, setMessage] = useState<string>('');
    const [resetKey, setResetKey] = useState<string>('');

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        const username = localStorage.getItem('username');
        const password = localStorage.getItem('password');
        event.preventDefault();

        const form = event.target as HTMLFormElement;
        const employeeData = {
            firstName: form['first-name'].value,
            lastName: form['last-name'].value,
            email: form.email.value,
            phoneNumber: form['phone-number'].value
        };

        const authHeader = username && password ? `Basic ${btoa(`${username}:${password}`)}` : undefined;

        try {
            const response = await axios.put(`http://localhost:8080${url}`, employeeData, {
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

    return (
        <div>
            <h2>Add Employee</h2>
            <div className="form-holder">
                <form onSubmit={handleSubmit}>
                    <div className="form-input">
                        <label htmlFor="first-name">First Name:</label>
                        <input name="first-name" type="text" required />
                    </div>
                    <div className="form-input">
                        <label htmlFor="last-name">Last Name:</label>
                        <input name="last-name" type="text" required />
                    </div>
                    <div className="form-input">
                        <label htmlFor="email">E-mail:</label>
                        <input name="email" type="text" required />
                    </div>
                    <div className="form-input">
                        <label htmlFor="phone-number">Phone number:</label>
                        <input name="phone-number" type="text" required />
                    </div>
                    <div className="form-input">
                        <input type="submit" className="button" value="Submit" />
                    </div>
                </form>
                <SubmissionMessage key={resetKey} message={message} />
            </div>
        </div>
    );
};

export default AddEmployee;