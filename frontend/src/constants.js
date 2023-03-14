const BACKEND_HOST = process.env.BACKEND_HOST ? process.env.BACKEND_HOST : 'localhost';

export const SESSION_URL = `http://${BACKEND_HOST}/getChallengeStatus/session/main`;
export const LEETCODE_PROBLEM_BASE_URL = 'https://leetcode.com/problems';
export const LEETCODE_BASE_URL = 'https://leetcode.com';