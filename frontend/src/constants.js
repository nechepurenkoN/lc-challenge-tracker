// const BACKEND_HOST = process.env.BACKEND_HOST ? process.env.BACKEND_HOST : 'localhost';
const BACKEND_HOST = 'lc-challenge-tracker.nechn.nl';

export const SESSION_URL = `http://${BACKEND_HOST}/api/challenge/session/main`;
export const HISTORY_URL = `http://${BACKEND_HOST}/api/challenge/history/main`;
export const LEETCODE_PROBLEM_BASE_URL = 'https://leetcode.com/problems';
export const LEETCODE_BASE_URL = 'https://leetcode.com';