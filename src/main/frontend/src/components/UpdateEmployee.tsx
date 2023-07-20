import React, { useState } from "react";
import SubmissionMessage from "./SubmissionMessage.tsx";
import axios from "axios";

const UpdateEmployee: React.FC<{ url: string }> = ({ url }) => {
    const [message, setMessage] = useState<string>("");
    const [resetKey, setResetKey] = useState<string>("");
    const [id, setId] = useState<string>(""); // New state to store the ID

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        const username = localStorage.getItem("username");
        const password = localStorage.getItem("password");
        event.preventDefault();

        const form = event.target as HTMLFormElement;
        const employeeData = {
            id: id, // Include the ID in the data
            firstName: form["first-name"].value,
            lastName: form["last-name"].value,
            email: form.email.value,
            phoneNumber: form["phone-number"].value,
        };

        const authHeader = username && password ? `Basic ${btoa(`${username}:${password}`)}` : undefined;

        try {
            await axios.put(`http://localhost:8080${url}${id}`, employeeData, {
                headers: {
                    Authorization: authHeader,
                },
            });
            setMessage("Employee updated");
            setResetKey(Date.now().toString());
            form.reset();
        } catch (error) {
            setMessage("Please log in or check your inputs");
        }
    };

    return (
        <div>
            <h2>Update Employee</h2>
            <div className="form-holder">
                <form onSubmit={handleSubmit}>
                    <div className="form-input">
                        <label htmlFor="id">Employee ID:</label>
                        <input name="id" type="text" value={id} onChange={(e) => setId(e.target.value)} required />
                    </div>
                    <div className="form-input">
                        <label htmlFor="first-name">First Name:</label>
                        <input name="first-name" type="text" />
                    </div>
                    <div className="form-input">
                        <label htmlFor="last-name">Last Name:</label>
                        <input name="last-name" type="text" />
                    </div>
                    <div className="form-input">
                        <label htmlFor="email">E-mail:</label>
                        <input name="email" type="text" />
                    </div>
                    <div className="form-input">
                        <label htmlFor="phone-number">Phone number:</label>
                        <input name="phone-number" type="text" />
                    </div>
                    <div className="form-input">
                        <input type="submit" className="button" value="Update" />
                    </div>
                </form>
                <SubmissionMessage key={resetKey} message={message} />
            </div>
        </div>
    );
};

export default UpdateEmployee;