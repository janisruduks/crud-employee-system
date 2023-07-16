import './style.css';
import React, {useEffect, useState} from "react";

const SubmissionMessage: React.FC<{message:string}> = ({message}) => {
    const [displayMessage, setDisplayMessage] = useState(true);

    useEffect(() => {
        setDisplayMessage(true);
        if (message) {
            const timer = setTimeout(() => {
                setDisplayMessage(false);
            }, 3000);

            return () => clearTimeout(timer);
        }
    }, [message]);

    return (
        <div>
            {displayMessage && <div className="success-message">{message}</div>}
        </div>
    );
};

export default SubmissionMessage;