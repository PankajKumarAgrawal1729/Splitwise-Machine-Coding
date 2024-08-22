<h3>Requirements</h3>
<ul>
    <li>User: Each user should have a userId, name, email, mobile number.</li>
    <li>Expense: Could either be EQUAL, EXACT or PERCENT</li>
    <li>Users can add any amount, select any type of expense and split with any of the available users.</li>
    <li>The percent and amount provided could have decimals upto two decimal places.</li>
    <li>In case of percent, you need to verify if the total sum of percentage shares is 100 or not.</li>
    <li>In case of exact, you need to verify if the total sum of shares is equal to the total amount or not.</li>
    <li>The application should have a capability to show expenses for a single user as well as balances for
        everyone.
    </li>
    <li>When asked to show balances, the application should show balances of a user with all the users where there
        is a non-zero balance.
    </li>
    <li>The amount should be rounded off to two decimal places. Say if User1 paid 100 and amount is split equally
        among 3 people. Assign 33.34 to first person and 33.33 to others.
    </li>
</ul>
<h3>Input</h3>
<ul>
    <li>You can create a few users in your main method. No need to take it as input.</li>
    <li>There will be 3 types of input:
        <ul>
            <li>Expense in the format: <code>EXPENSE &lt;user-id-of-person-who-paid&gt; &lt;no-of-users&gt; &lt;space-separated-list-of-users&gt; &lt;EQUAL/EXACT/PERCENT&gt; &lt;space-separated-values-in-case-of-non-equal&gt;</code>
            </li>
            <li>Show balances for all: <code>SHOW</code></li>
            <li>Show balances for a single user: <code>SHOW &lt;user-id&gt;</code></li>
        </ul>
    </li>
</ul>
<h3>Output</h3>
<ul>
    <li>When asked to show balance for a single user. Show all the balances that user is part of:</li>
    <li>Format: <code>&lt;user-id-of-x&gt; owes &lt;user-id-of-y&gt;: &lt;amount&gt;</code></li>
    <li>If there are no balances for the input, print <code>No balances</code></li>
    <li>In cases where the user for which balance was asked for, owes money, they’ll be x. They’ll be y otherwise.</li>
</ul>
<h3>Sample Input</h3>
<pre class="plaintext hljs"><code>SHOW
SHOW u1
EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
SHOW u4
SHOW u1
EXPENSE u1 1250 2 u2 u3 EXACT 370 880
SHOW
EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
SHOW u1
SHOW
</code></pre>
<h3>Sample Output</h3>
<pre class="plaintext hljs"><code>No balances
No balances
User4 owes User1: 250
User2 owes User1: 250
User3 owes User1: 250
User4 owes User1: 250
User2 owes User1: 620
User3 owes User1: 1130
User4 owes User1: 250
User1 owes User4: 230
User2 owes User1: 620
User3 owes User1: 1130
User1 owes User4: 230
User2 owes User1: 620
User2 owes User4: 240
User3 owes User1: 1130
User3 owes User4: 240
</code></pre>

[Question URL](https://workat.tech/machine-coding/practice/splitwise-problem-0kp2yneec2q2)