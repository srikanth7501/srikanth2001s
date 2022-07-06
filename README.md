#include <bits/stdc++.h>
using namespace std;
int bookingNo = 0;
class Ticket
{
public:
float adult_1 = 200;
float adult_2 = 300;
float child_1 = 120;
float child_2 = 180;
float senior_1 = 160;
float senior_2 = 240;
// 2 adults and 3 children
float family_1 = 600;
float family_2 = 900;
// group of six or morev the price is per person
float six_1 = 150;
float six_2 = 220.5;
// lion feeding
float lion = 20.5;
// penguin feeding
float penguin = 20;
// evening Barbeque on on two day ticket
float Barbeque = 50;
float noOfAdults, noOfChilds, noOfSeniors, days, date;
// ticket needed
int adult, senior, child, family, six;
bool lionFeedNeeded = false, penguinFeedNeeded = false, barbequeNeeded = false;
float value;
// finding the bill
int total()

{
float totalPeoples;
totalPeoples = noOfAdults + noOfChilds + noOfSeniors;
if (days == 1)
{
value = adult * adult_1 + child * child_1 + family * family_1 + senior * senior_1;
if ((int(noOfAdults + noOfSeniors) % 2 == 0) && (int(noOfChilds) % 3 == 0))
{
cout << "\nA family Ticket is Better for You!" << endl;
string takefamily;
cout << "Book the family ticket?(yes or no) ";
cin >> takefamily;
if (takefamily == "yes")
{
value = ((totalPeoples / 5) * family_1);
}
}
else
{
cout << "A Group Ticket is Better for You!" << endl;
string takegroup;
cout << "Book the group ticket?(yes or no) ";
cin >> takegroup;
if (takegroup == "yes")
{
value = min(((noOfAdults * adult_1) + (noOfChilds * child_1) + (noOfSeniors *

senior_1)), (totalPeoples * six_1));
}
}
}
if (days == 2)
{
value = adult * adult_2 + child * child_2 + family * family_2 + senior * senior_2;
if ((int(noOfAdults + noOfSeniors) % 2 == 0) && (int(noOfChilds) % 3 == 0))
{
cout << "\nA family Ticket is Better for You!" << endl;
string takefamily;
cout << "Book the family ticket?(yes or no) " << endl;
cin >> takefamily;
if (takefamily == "yes")
{
value = ((totalPeoples / 5) * family_2);
}
}

else
{
cout << "\nA Group Ticket is Better for You!";
string takegroup;
cout << "\nBook the group ticket?(yes or no) " << endl;
cin >> takegroup;
if (takegroup == "yes")
{
value = min(((noOfAdults * adult_2) + (noOfChilds * child_2) + (noOfSeniors *

senior_2)), (totalPeoples * six_2));
}
}
}
if (lionFeedNeeded)
{
value += lion * totalPeoples;
}
if (penguinFeedNeeded)
{
value += penguin * totalPeoples;
}
if (barbequeNeeded)
{
value += Barbeque * totalPeoples;
}
return value;
}
};
int main()
{
Ticket obj;
cout << "Welcome!\n";
cout << "Here are the various options we Provide" << endl;
cout << "---------------------------------For One day---------------------------------\n\n";
cout << ">>>Options\n\n";
cout << "Persons\t\t\t\t\t\t\t\tCost\n";
cout << "1 Adult"
<< "\t\t\t\t\t\t\t\t" << obj.adult_1 << endl;
cout << "1 Child"
<< "\t\t\t\t\t\t\t\t" << obj.child_1 << endl;
cout << "1 Senior"

<< "\t\t\t\t\t\t\t" << obj.senior_1 << endl;
cout << "1 family(up to two adults orseniors, and three children)"
<< "\t" << obj.family_1 << endl;
cout << "groups ofsix people or more, price per person"
<< "\t\t\t" << obj.six_1 << endl;
cout << "\n";
cout << ">>>Attractions\n\n";
cout << "Attraction\t\t\t\t\t\t\t\tCost Per person\n";
cout << "Lion Feeding"
<< "\t\t\t\t\t\t\t\t" << obj.lion << endl;
cout << "Penguin Feeding"
<< "\t\t\t\t\t\t\t\t" << obj.penguin << endl;
cout << "\n---------------------------------For Two day---------------------------------\n\n";
cout << ">>>Options\n\n";
cout << "Persons\t\t\t\t\t\t\t\tCost\n";
cout << "1 Adult"
<< "\t\t\t\t\t\t\t\t" << obj.adult_2 << endl;
cout << "1 Child"
<< "\t\t\t\t\t\t\t\t" << obj.child_2 << endl;
cout << "1 Senior"
<< "\t\t\t\t\t\t\t" << obj.senior_2 << endl;
cout << "1 family(up to two adults orseniors, and three children)"
<< "\t" << obj.family_2 << endl;
cout << "groups ofsix people or more, price per person"
<< "\t\t\t" << obj.six_2 << endl;
cout << "\n";
cout << ">>>Attractions\n\n";
cout << "Attraction\t\t\t\t\t\t\t\tCost Per person\n";
cout << "Lion Feeding"
<< "\t\t\t\t\t\t\t\t" << obj.lion << endl;
cout << "Penguin Feeding"
<< "\t\t\t\t\t\t\t\t" << obj.penguin << endl;
cout << "Evening Barbacue(only in two day ticket)"
<< "\t\t\t\t" << obj.Barbeque << endl;
cout << "\n\n";
cout << "Days available for Booking\n\n";
// showing the date available for booking
time_t t;
t = time(NULL);

struct tm tm = *localtime(&t);
for (int i = 0; i < 7; i++)
{
cout << tm.tm_mday + i << "-" << tm.tm_mon + 1 << "-" << tm.tm_year + 1900 << endl;
}
cout << "\n------------------------------------------------------------------------\n";
// getting input of the no. of adults seniors and childs
cout << "\nEnter the no. of Adults : ";
cin >> obj.noOfAdults;
cout << "\nEnter the no. of Children :";
cin >> obj.noOfChilds;
cout << "\nEnter the no. of Senior Citizens : ";
cin >> obj.noOfSeniors;
cout << "\n";
// checking if more than 2 children are going on one adults
if (obj.noOfChilds > 2 * obj.noOfAdults)
{
cout << "Not allowed only two childs allowed per adult" << endl;
}
cout << "\nEnter the no. of days you want to book?(only 1 or 2) : ";
cin >> obj.days;
cout << "\nEnter the date you want to book? (Between " << tm.tm_mday << " to " <<
tm.tm_mday + 6 << " ): ";
cin >> obj.date;
if (obj.date > tm.tm_mday + 6 && obj.date < tm.tm_mday)
{
cout << "Enter correct value" << endl;
cout << "\nEnter the date you want to book? (Between " << tm.tm_mday << " to " <<
tm.tm_mday + 6 << " ): ";
}
// gettings the tickets user want
cout << "\nEnter the no. of Adult Ticket wanted : ";
cin >> obj.adult;
cout << "\nEnter the no. of child Ticket wanted:";
cin >> obj.child;
cout << "\nEnter the no. of Senior Tickets wanted : ";
cin >> obj.senior;
cout << "\nEnter the no. of family Tickets wanted : ";
cin >> obj.family;
cout << "\nEnter the no. of group of six Tickets wanted : ";

cin >> obj.six;
cout << "\n";
// checking if they want to feed Lions
string lionfeedvalue;
cout << "\nWant to include Lion Feeding?(yes or no) : ";
cin >> lionfeedvalue;
if (lionfeedvalue == "yes")
{
obj.lionFeedNeeded = true;
}
// checking if they want to feed Penguins
string penguinFeedValue;
cout << "\nWant to include Penguin Feeding?(yes or no) : ";
cin >> penguinFeedValue;
if (penguinFeedValue == "yes")
{
obj.penguinFeedNeeded = true;
}
// checking if the need a barbaque
if (obj.days == 2)
{
string barbaqueNeededValue;
cout << "\nWant to include barbaque?(yes or no) : ";
cin >> barbaqueNeededValue;
if (barbaqueNeededValue == "yes")
{
obj.barbequeNeeded = true;
}
}
bookingNo++;
obj.total();
cout << "\nTotal Cost is :" << obj.value << endl;
cout << "Your Booking no. is " << bookingNo << endl;
cout << "Booking date is " << obj.date << endl;
cout << "Booking done for " << obj.noOfAdults << " adults " << obj.noOfSeniors << " Senior
Citizens " << obj.noOfChilds << " Childs " << endl;
return 0;
}
