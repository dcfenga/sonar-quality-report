/**
 * Here are all the function used to interact with SonarQube API
 */

import {getJSON, post, postJSON} from "sonar-request";

// Function used to revoke the plugin token
function revokeToken(name) {
    return post("/api/user_tokens/revoke", {"name": name});
}

// Function used to create the plugin token
function createToken(name) {
    return postJSON("/api/user_tokens/generate", {"name": name});
}

// Function used to get the current logged user name
function getUserName(login) {
    return getJSON("/api/users/search", {"q": login}).then(response => {
        return response.users[0].name;
    });
}

// Macro function used to execute the whole plugin token process
export function initiatePluginToken() {
    const name = "html-report";

    return revokeToken(name).then(() => {
        return createToken(name).then(tokenResponse => {
            return getUserName(tokenResponse.login).then(userResponse => {
                return {
                    token: tokenResponse.token,
                    author: userResponse
                }
            });
        });
    });
}