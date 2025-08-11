Directed Kidney Donation
Kidneys are organs in the human body whose function is critical for maintaining life. Put simply,
the kidneys primarily serve to regulate the salinity, water content, and pH of one's blood, and
also remove toxins from the body. If someone has no working kidneys then they must either
receive frequent kidney dialysis (which cycles blood through a machine to perform the function
of a kidney), or else receive a kidney transplant from an organ donor.
Humans are generally born with two kidneys, and one functioning kidney is sufficient for
survival, so it is possible (though not risk-free) for a living person to donate a kidney to a patient
in need. To protect from disease, the human immune system has evolved to recognize and
attack cells from other individuals. As such, before donation, we must check whether a donor
and recipient are compatible. Donor-patient compatibility is determined by weighing many
factors, but one important factor is HLA match compatibility.
Human Leukocyte Antigens (HLAs) are proteins that attach to the membranes of cells to help
the immune system identify which cells are "self" cells and which are "invader" cells. Each
person has a collection of different HLAs, and the more HLAs that are shared between the
donor and the recipient the safer the transplant will be. The similarity is measured by a "HLA
match score"
. For this assignment, we will consider a patient and donor to be compatible
in the case that their match score is at least 60.
When someone wishes to donate a kidney, there are two main ways they can donate. They can
give a “directed donation”
, meaning they wish to donate to a specific person. They could also
give a “non-directed donation”
, meaning they choose to donate without knowing the recipient.
Because of all the factors at play for donor-recipient compatibility, it may be the case that a
recipient does not know anyone who would be a matching directed donor. To help patients find
donors, donation networks have been set up. The idea is that if Recipient A needs a kidney, but
their friend Donor A is not compatible, then perhaps Donor A could give a kidney to compatible
Recipient B in exchange for Donor B giving a kidney to Recipient A. So in short, if Recipient A
has no known donors, they can try to identify a "kidney trade" with another recipient using one of
their directed donors. These trades could also be larger "kidney donation cycles"
, where Donor
A gives to Recipient B, Donor B gives to recipient C, and Donor C gives to recipient A. For the
sake of this assignment, our cycles can be of any length, but they must be cycles (the idea
being that Donor A is a directed donor and so is only willing to donate a kidney if the result is
Recipient A receiving one).
Problem Statement
For this assignment you will implement an algorithm to identify whether a given recipient can
receive a kidney through a donation cycle.
A donation cycle is defined to be a sequence of kidney recipients such that for
𝑟
0, 𝑟
1, ..., 𝑟
𝑥
, 𝑟
0
each choice of there is a directed donor for recipient who has an HLA match score of at least
𝑖 𝑟
𝑖
60 with recipient . In other words, it is a cycle of recipients such that each recipient in the
𝑟
𝑖+1
cycle can receive a kidney from one of the donors associated with the recipient before them in
the cycle.
For this assignment we will give you a list of directed donors (and the recipients whom they wish
to benefit) as well as HLA match scores for each donor-recipient pair. You will then convert that
information into a graph, and then implement a method that will give a donor cycle which
includes a given recipient, or else indicate that no such cycle exists. You may assume that no
donor has a match with the recipient they wish to benefit.
Input Format: For this assignment, input will be encoded in txt files. Supposing that each test
consists of n recipients and m donors, the files will contain m+4 lines as follows:

The first line contains the value n (the number of recipients)

The next line contains the value m (the number of donors)

The next line contains m comma-separated integers between 0 and n-1 to indicate the
recipient whom each donor wishes to benefit (so if the ith integer is j, that means donor i
wishes for recipient j to receive a kidney)

The next m lines each contain n comma-separated integers. Collectively, these n*m
integers give the HLA match scores for all donor-recipient pairs. We consider a score of
60 or higher to be suitable for donation.

The last line contains an integer between 0 and n-1 to indicate a recipient. This recipient
will be given as input to your algorithm, which will attempt to find a cycle that includes
that recipient.
For example, if the file’s contents were as shown on the left, then the graph would appear as on
the right.
3
9
0,0,0,1,1,1,1,2,2
10,15,20
20,20,9
0,71,20
2,2,2
3,3,3
4,4,4
5,5,100
90,0,0
90,0,0
0
When processing the file line-by-line we see that:

There are 3 recipients (hence 3 nodes in the graph)

There are 9 donors

Donors 0, 1, and 2 wish for recipient 0 to receive a kidney, donors 3, 4, 5, and 6 wish to
benefit recipient 1, and donors 7, and 8 wish to benefit recipient 2

Donor 0 does not have a strong enough match to donate to any of the three recipients
(no scores are 60 or greater)

Donor 1 does not have a strong enough match to donate to any of the three recipients
(no scores are 60 or greater)

Donor 2 is compatible with recipient 1, therefore we draw an edge from node 0 (Donor
2’s beneficiary) to node 1 (Donor 2’s match)

Repeat the above for donors 3-8

Since the last line has the value 0, your algorithm should find a cycle which includes
recipient 0. In the graph this would be [0, 1, 2, 0].
